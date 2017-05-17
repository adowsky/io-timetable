import React from "react";

export default class DayView extends React.Component {
    render() {
        return (
            <div>
                <div className="heading grid">{this.props.dayId}</div>
                { this.props.day.map(day =>
                    (day.type === "artificial") ? <div key={day.hour} className="block grid"></div> :
                        <div className={`${day.week} block grid ${day.type}`} key={day.hour}>
                            <div>{day.teacher}</div>
                            <div>{day.subject}</div>
                            <div>{day.classroom}</div>
                        </div>) }
            </div>
        );
    }
}