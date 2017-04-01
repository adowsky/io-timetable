import React from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import RestClient from "./RestClient";
import ApplicationView from "./ApplicationView";
import MainMenu from "./menu/MainMenu";
import TimetableImporter from "./import/TimetableImporter";
import NotFoundView from './error/NotFoundView';

export default class Application extends React.Component {
    static childContextTypes = {
        restClient: React.PropTypes.any
    }

    constructor(props) {
        super(props);
        this.restClient = new RestClient();

        this.state = {
            modelField: ""
        }
    }


    getChildContext() {
        return {
            restClient: this.restClient
        };
    }

    componentDidMount() {
        this.restClient.getRequest("http://localhost:8080/api/my-message")
            .then(response => this.setState(response));

    }


    render() {
        return (
            <ApplicationView>
                <Router>
                    <div className="root">
                        <Switch>
                            <Route exact path='/' component={MainMenu}/>
                            <Route path='/import-timetable' component={TimetableImporter}/>
                            <Route path="/*" component={NotFoundView}/>
                        </Switch>
                    </div>
                </Router>
            </ApplicationView>
        );
    }
}
