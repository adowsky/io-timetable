import React from 'react';
import ApplicationView from "./ApplicationView";
import RestClient from "./RestClient";

export default class Application extends React.Component {
    constructor(props) {
        super(props);
        this.restClient = new RestClient();

        this.state = {
            modelField: ""
        }
    }

    componentDidMount() {
        this.restClient.getRequest("http://localhost:8080/my-endpoint/my-message")
            .then(response =>  this.setState(response));

    }


    render() {
        return (<ApplicationView field={ this.state.modelField } />);
    }
}
