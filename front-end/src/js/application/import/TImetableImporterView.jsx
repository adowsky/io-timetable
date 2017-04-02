import React from 'react';

const getProcessingViewForStatus = (status) => {
    switch (status) {
        case "SENDING":
            return <h2>Trwa wysyłanie</h2>;
            break;
        case "COMPLETE":
            return <h2>Wysyłanie zakończone pomyślnie</h2>;
            break;
        case "FAIL":
            return <h2>Wysyłanie zakończone niepowodzeniem</h2>;
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

        return (
            <div>
                <form onSubmit={this.props.send}>
                    <div className="file-chooser">
                        <span >
                            <h4 className={`input-placeholder ${placeholderTransitionStyle}`}>Plik z planem</h4>
                            <h4>{filename}</h4>
                        </span>
                        <label htmlFor="timetable">Wybierz plik</label>
                        <input type="file" name="timetable" id="timetable" accept=".csv" onChange={this.props.handle}/>
                    </div>
                    <input type="submit" disabled={!this.props.filename}/>
                </form>

                {getProcessingViewForStatus(this.props.status)}
            </div>
        );
    }
}
