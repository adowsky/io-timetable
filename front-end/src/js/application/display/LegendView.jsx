import React from "react";

export default class LegendView extends React.Component {
    render() {
        return (
            <div className="legend">
                <div><h2>Legend</h2></div>
                <div>
                <div className="explanation PARZYSTY">Parzysty</div>
                <div className="explanation NIEPARZYSTY">Nieparzysty</div>
                </div>
                <div>
                <div className="explanation WYKŁAD">Wykład</div>
                <div className="explanation LABORATORIA">Laboratoria</div>
                <div className="explanation ĆWICZENIA">Ćwiczenia</div>
                </div>
            </div>
        );
    }
}