import React from "react";

import DayView from "./DayView";
import LegendView from "./LegendView";

const hours = [
    "8:00-9:30",
    "9:45-11:15",
    "11:45-13:15",
    "13:30-15:00",
    "15:10-16:40",
    "16:50-18:20",
    "18:30-20:00",
    "20:10-21:40"
];

export default class TimetableDisplay extends React.Component {
    static contextTypes = {
        restClient: React.PropTypes.any
    };

    constructor(...props) {
        super(...props);

        this.state = {
            timetable: []
        }
    }

    componentDidMount() {
        const insertEmpties = (day, dayName) => {
            let idx = 1;
            const lastHour = (day && day.length > 0) ? day[day.length - 1].hour : 1 ;
            while (idx.toString() !== lastHour.toString()) {
                if (day[idx - 1].hour !== idx.toString()) {
                    day.splice(idx - 1, 0, {
                        hour: idx.toString(),
                        type: "artificial",
                        day: dayName
                    });
                }
                idx++;
            }
            if(day && day.length > 0) {
                idx++;
            }
            
            while (idx < 9) {
                day.splice(idx - 1, 0, {
                    hour: idx.toString(),
                    type: "artificial",
                    day: dayName
                });
                idx++;
            }
        };
        const { department, faculty, semester, group } = this.props.match.params;
        this.context.restClient.getRequest(`/api/departments/${department}/${faculty}/${semester}/${group}/timetable`)
            .then(timetable => {
                const monday = timetable.filter(t => t.day === "PONIEDZIAŁEK");
                const tuesday = timetable.filter(t => t.day === "WTOREK");
                const wednesday = timetable.filter(t => t.day === "ŚRODA");
                const thursday = timetable.filter(t => t.day === "CZWARTEK");
                const friday = timetable.filter(t => t.day === "PIĄTEK");

                insertEmpties(monday, "PONIEDZIAŁEK");
                insertEmpties(tuesday, "WTOREK");
                insertEmpties(wednesday, "ŚRODA");
                insertEmpties(thursday, "CZWARTEK");
                insertEmpties(friday, "PIĄTEK");
                timetable = monday.concat(tuesday).concat(wednesday).concat(thursday).concat(friday);
                this.setState({ timetable });
            });
    }

    render() {
        const monday = this.state.timetable.filter(t => t.day === "PONIEDZIAŁEK");
        const tuesday = this.state.timetable.filter(t => t.day === "WTOREK");
        const wednesday = this.state.timetable.filter(t => t.day === "ŚRODA");
        const thursday = this.state.timetable.filter(t => t.day === "CZWARTEK");
        const friday = this.state.timetable.filter(t => t.day === "PIĄTEK");
        return (
            <div className="timetable">
                <div>
                    <div className="grid"/>
                    {hours.map(hour => <div key={hour} className="grid">{hour}</div>)}</div>
                <DayView day={ monday } dayId="PONIEDZIAŁEK"/>
                <DayView day={ tuesday } dayId="WTOREK"/>
                <DayView day={ wednesday } dayId="ŚRODA"/>
                <DayView day={ thursday } dayId="CZWARTEK"/>
                <DayView day={ friday } dayId="PIĄTEK"/>
                <LegendView/>
            </div>
        );
    }

}