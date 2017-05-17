import React from 'react';

import FacultyView from './FacultyView';

const getProcessingViewForStatus = (status) => {
    switch (status) {
        case "SENDING":
            return <span className="inline info"><span className="fa fa-spinner rotate" aria-hidden="true"/><h2>Trwa wysyłanie</h2></span>;
            break;
        case "COMPLETE":
            return <span className="inline info"><span className="fa fa-check-circle-o" aria-hidden="true"/><h2>Wysyłanie zakończone pomyślnie</h2></span>;
            break;
        case "FAIL":
            return <span className="inline info"><span className="fa fa-times-circle-o" aria-hidden="true"/><h2>Wysyłanie zakończone niepowodzeniem</h2></span>;
            break;
        default:
            return <h2/>;
    }
};

export default class TimetableImporterView extends React.Component {
    constructor(props) {
        super(props);

        this.ref = {
            file: null
        }
    }

    render() {
        const filename = this.props.filename || "";
        const placeholderTransitionStyle = (this.props.filename) ? "filled" : "";
        const shouldDisableButton = (!this.props.filename || !this.props.form.faculty || !this.props.form.department || !this.props.form.semester || !this.props.form.group)
            || this.props.status === "SENDING";
        const faculties = this.props.faculties || [];
        console.log(this.props.form.department);
        
        return (
            <div>
                <form onSubmit={this.props.send}>
                    <div className="selectable">
                        <label>Department</label>
                        <select value={this.props.form.department} name="department" onChange={this.props.handleChange}>
                            <option />
                            {this.props.departments.map(d => <option value={d} key={d}>{d}</option>)}
                        </select>


                    <FacultyView form={this.props.form} faculties={faculties} handleChange={this.props.handleChange}/>
                    </div>
                    <div>
                        <div className="file-chooser">
                        <span>
                            <h4 className={`input-placeholder ${placeholderTransitionStyle}`}>Plik z planem</h4>
                            <h4>{filename}</h4>
                        </span>
                            <label htmlFor="timetable">Wybierz plik</label>
                            <input type="file" name="timetable" id="timetable" accept=".csv"
                                   onChange={this.props.handle}/>
                        </div>
                        <input type="submit" disabled={shouldDisableButton}/>
                    </div>

                </form>

                {getProcessingViewForStatus(this.props.status)}
            </div>
        );
    }
}
