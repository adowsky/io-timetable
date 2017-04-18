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
            timetable: null,
            departments: [],
            faculties: [],
            form: {
                department: "",
                faculty: "",
                semester: "",
                group: ""
            }
        };

        this.handle = this.handle.bind(this);
        this.send = this.send.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        this.context.restClient.getRequest("/api/departments")
            .then(departments => this.setState({departments}));
    }

    componentDidUpdate(prevProps, prevState) {
        if(this.state.form.department !== prevState.form.department) {
            this.context.restClient.getRequest(`/api/departments/${this.state.form.department}`)
                .then(faculties => this.setState(faculties));
        }
    }

    send(event) {
        event.preventDefault();
        const {department, faculty, semester, group} = this.state.form;
        const file = event.target.elements["timetable"].files[0];
        const fileReader = new FileReader();
        fileReader.onload = () => {
            const headers = {
                "Content-Type": "text/csv"
            };
            this.context.restClient.multipartPostRequest(
                `http://localhost:8080/api/departments/${department}/${faculty}/${semester}/${group}/timetable`,
                    fileReader.result, headers)
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

    handleChange(event) {
        const {name, value} = event.target;
        const newForm = Object.assign({}, this.state.form, {
            [name] : value
        });
        const newState = Object.assign({}, this.state, {
            form: newForm
        });

        this.setState(newState);

    }


    render() {
        return (
            <TimetableImporterView
                filename={this.state.timetable}
                handle={this.handle}
                send={this.send}
                status={this.state.status}
                form={this.state.form}
                departments={this.state.departments}
                faculties={this.state.faculties}
                handleChange={this.handleChange}
            />
        );
    }
}
