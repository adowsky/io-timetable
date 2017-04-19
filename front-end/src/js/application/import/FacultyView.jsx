import React from 'react';

export default class FacultyView extends React.Component {
    render() {
        const {faculty, semester, group} = this.props.form;
        const semesters = this.props.faculties[faculty] || [];
        const groups = semesters[semester] || [];


        return (
          <div>
              <div>
                  <label>Faculty</label>
                  <select value={faculty} name="faculty" onChange={this.props.handleChange}>
                      <option />
                      {Object.keys(this.props.faculties).map(d => <option value={d} key={d}>{d}</option>)}
                  </select>
              </div>
              <div>
                  <label>Semester</label>
                  <select value={semester} name="semester" onChange={this.props.handleChange}>
                      <option />
                      {Object.keys(semesters).map(d => <option value={d} key={d}>{d}</option>)}
                  </select>
              </div>
              <div>
                  <label>Group</label>
                  <select value={group} name="group" onChange={this.props.handleChange}>
                      <option />
                      {groups.map(d => <option value={d} key={d}>{d}</option>)}
                  </select>
              </div>
          </div>
        );
    }
}