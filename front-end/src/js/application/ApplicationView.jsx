import React from 'react';

export default class ApplicationView extends React.Component {
    constructor(props) {
        super(props);

    }

    render() {
        let a = [];
        return (
            <div> { this.props.field } </div>
        );
    }
}
