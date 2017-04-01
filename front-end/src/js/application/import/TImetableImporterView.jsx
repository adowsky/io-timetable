import React from 'react';

export default class TimetableImporterView extends React.Component {

    render() {
        const filename = this.props.filename || "";
        const placeholderTransitionStyle = (this.props.filename) ? "filled" : "";

        return (
            <div>
                <form onSubmit={this.props.send}>
                    <div className="file-chooser">
                        <span >
                            <h4 className={`input-placeholder ${placeholderTransitionStyle}`}>Plik z planem</h4>
                            <h4>{filename}</h4>
                        </span>
                        <label htmlFor="timetable">Wybierz plik</label>
                        <input type="file" name="timetable" id="timetable" accept="*.csv" onChange={this.props.handle}/>
                    </div>
                    <input type="submit" disabled={!this.props.filename}/>
                </form>
            </div>
        );
    }
}
