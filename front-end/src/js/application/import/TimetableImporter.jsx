import React from 'react';
import TimetableImporterView from "./TimetableImporterView";

export default class TimetableImporter extends React.Component {
    static contextTypes = {
        restClient: React.PropTypes.any
    };

    constructor(...props) {
        super(...props);

        this.state = {
            status: "",
            timetable: null
        };

        this.handle = this.handle.bind(this);
        this.send = this.send.bind(this);
    }

    send(event) {
        event.preventDefault();

        const file = event.target.elements["timetable"].files[0];
        const fileReader = new FileReader();
        fileReader.onload = () => {
            this.context.restClient.multipartPostRequest("http://localhost:8080/api/import-timetable", fileReader.result)
                .then(() =>this.setState({status: "COMPLETE"}))
                .catch(() => this.setState({status: "FAIL"}));
        };
        fileReader.readAsArrayBuffer(file);

        this.setState({status: "SENDING"})
    }

    handle(event) {
        let newState = Object.assign({}, this.state);
        let value = event.target.value;
        const lastSlashIndex = value.lastIndexOf("\\");
        value = value.substr(lastSlashIndex + 1);
        newState[event.target.name] = value;
        this.setState(newState);
    }


    render() {
        return (
            <TimetableImporterView
                filename={this.state.timetable}
                handle={this.handle}
                send={this.send}
                status={this.state.status}
            />
        );
    }
}
