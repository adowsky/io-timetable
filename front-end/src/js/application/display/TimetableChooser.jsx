import React from "react";
import {Link} from "react-router-dom";

import FacultyView from "../import/FacultyView";

export default class TimetableChooser extends React.Component {
    static contextTypes = {
        restClient: React.PropTypes.any
    };

     constructor(...props) {
         super(...props);
         this.state = {
             departments: [],
             faculties: [],
             form: {
                 department: "",
                 faculty: "",
                 semester: "",
                 group: ""
             }
         }
     }

    componentDidUpdate(prevProps, prevState) {
        if(this.state.form.department !== prevState.form.department) {
            this.context.restClient.getRequest(`/api/departments/${this.state.form.department}`)
                .then(faculties => this.setState(faculties));
        }
    }


    componentDidMount() {
        this.context.restClient.getRequest("/api/departments")
            .then(departments => this.setState({departments}));
    }

    handleToPlanClick = event => {
        const { department, faculty, group, semester } = this.state.form;
         if(!department || !faculty || !group || !semester)
             event.preventDefault();
    };

    handleChange = (event) => {
        const {name, value} = event.target;
        const newForm = Object.assign({}, this.state.form, {
            [name] : value
        });
        const newState = Object.assign({}, this.state, {
            form: newForm
        });

        this.setState(newState);

    };

     render() {
         const { department, faculty, group, semester } = this.state.form;
         return (
             <div className="selectable">
                 <label>Department</label>
                 <select value={this.state.form.department} name="department" onChange={this.handleChange}>
                     <option />
                     {this.state.departments.map(d => <option value={d} key={d}>{d}</option>)}
                 </select>
                 <FacultyView form={this.state.form} faculties={this.state.faculties} handleChange={this.handleChange}/>

                 <Link to={`/timetable/${department}/${faculty}/${semester}/${group}`} onClick={this.handleToPlanClick} >
                     Przejdź do Planu
                 </Link>

             </div>
         );
         }
}