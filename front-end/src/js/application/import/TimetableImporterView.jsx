import React from 'react';

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
        const shouldDisableButton = !this.props.filename || this.props.status === "SENDING";

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
                    <input type="submit" disabled={shouldDisableButton}/>
                </form>

                {getProcessingViewForStatus(this.props.status)}
            </div>
        );
    }
}
