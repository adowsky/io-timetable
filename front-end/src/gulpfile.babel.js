'use strict';

import gulp from "gulp";
import babelify from "babelify";
import browserify from "browserify";
import source from "vinyl-source-stream";
import buffer from "vinyl-buffer";
import htmlmin from "gulp-htmlmin";
import image from "gulp-image";
import sass from "gulp-sass";
import uglify from "gulp-uglify";
import gulpif from "gulp-if";

const basePath = "target/_build/";
const SOURCE_PATH = "src/";

const PATHS = {
    entryPoint: `${SOURCE_PATH}js/start.jsx`,
    jsOut: `${basePath}js/all.js`,
    cssInput: `${SOURCE_PATH}css/style.css`,
    cssOutput: `${basePath}/css/style.css`,
    htmlInput: `${SOURCE_PATH}*.html`,
    imagesInput: `${SOURCE_PATH}/images/`,
    imagesOutput: `${basePath}/images/`,

};
const options = {
    browserify: {
        entries: PATHS.entryPoint,
        extensions: ['.jsx'],
        debug: true
    }
};

const isProduction = () => {
    return process.env.NODE_ENV === 'production';
};

gulp.task('prod', () => {
    process.env.NODE_ENV = 'production';
});

gulp.task('build:js', () => {
    return browserify(options.browserify)
        .transform(babelify)
        .bundle()
        .on("error", function (err) {
            console.log("Error : " + err.message);
        })
        .pipe(source(PATHS.jsOut))
        .pipe(buffer())
        .pipe(gulpif(isProduction(), uglify()))
        .pipe(gulp.dest('.'));
});

gulp.task('build:css', () => {
    return gulp.src(PATHS.cssInput)
        .pipe(sass((isProduction()) ? {style: 'compressed'} : {})
            .on('error', sass.logError))
        .pipe(gulp.dest(PATHS.cssOutput));
});

gulp.task('build:html', () =>
    gulp.src(PATHS.htmlInput)
        .pipe(htmlmin({collapseWhitespace: true}))
        .pipe(gulp.dest(basePath))
);

gulp.task('build:images', () => {
    gulp.src(PATHS.imagesInput)
        .pipe(image())
        .pipe(gulp.dest(PATHS.imagesOutput));
});

gulp.task('watch', () => {
    gulp.watch('front-end/src/js/**/*.jsx', ['build:js']);
    gulp.watch('front-end/js/css/**/*.scss', ['build:css']);
});

gulp.task('build', ['build:css', 'build:html', 'build:js', 'build:images']);

gulp.task('build:prod', ['prod', 'build:css', 'build:html', 'build:js', 'build:images']);

gulp.task('default', ['build:css', 'build:html', 'build:js', 'build:images', 'watch']);