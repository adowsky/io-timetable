import React from 'react';
import {Link} from "react-router-dom";

export default class MainMenuView extends React.Component {
    constructor(props) {
        super(props);

    }

    render() {
        return (
            <nav>
                <ul>
                    { this.props.entries
                        .map(entry => <li key={ entry.url } ><Link  to={ entry.url }>{ entry.title }</Link></li>) }
                </ul>
            </nav>
        );
    }
}
