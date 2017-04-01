import React from 'react';
import TimetableImporterView from "./TImetableImporterView";

export default class TimetableImporter extends React.Component {
    constructor(props) {
        super(props);

        this.state = {};

        this.handle = this.handle.bind(this);
        this.send = this.send.bind(this);
    }

    send(event) {
        event.preventDefault();
        console.log("sending timetable...");
    }

    handle(event) {
        let newState = Object.assign({}, this.state);
        newState[event.target.name] = event.target.value;
        this.setState(newState);
    }


    render() {
        return (
            <TimetableImporterView filename={this.state.timetable} handle={this.handle} send={this.send}/>
        );
    }
}
