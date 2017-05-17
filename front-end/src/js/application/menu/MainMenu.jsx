import React from 'react';

import MainMenuView from "./MainMenuView";

const getMenuEntries = () => {
    return [
        {
            url: "/import-timetable",
            title: "Wprowadź nowy plan"
        },
        {
            url: "/edit-timetable",
            title: "Edytuj istniejący plan"
        },
        {
            url: "/choose-timetable",
            title: "Wybierz plan do wyświetlenia"
        }
    ]
};

export default class MainMenu extends React.Component {
    static contextTypes = {
        restClient: React.PropTypes.any
    };



    constructor(...props) {
        super(...props);

        this.state = {
            entries: getMenuEntries()
        }
    }

    render() {
        return (
            <MainMenuView entries={ this.state.entries }/>
        );
    }
}
