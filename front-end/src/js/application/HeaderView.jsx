import React from 'react';

export default class HeaderView extends React.Component {
    constructor(props) {
        super(props);

    }

    render() {
        return (
            <header>
                {/*<img src="img/logo.png" alt="eStępstwa - System informacji o zastępstwach Politechniki Poznańskiej"/>*/}
                <h2>eStępstwa</h2>
                <p>System informacji o zastępstwach Politechniki Poznańskiej</p>
            </header>

        );
    }
}
