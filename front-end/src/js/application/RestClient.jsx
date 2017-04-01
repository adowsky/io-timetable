export default class RestClient {

    getRequest(url = "") {
        return fetch(url, {
            method: "GET"
        }).then(response => {
            if (response.status >= 200 && response.status < 300) {

                return response;
            } else {
                let error = new Error(response.statusText);
                error.response = response;
                throw error;
            }
        })
            .then(response =>  response.json())
            .then(response => {
                console.debug(`RESPONSE: ${JSON.stringify(response)}`);
                return response;
            })
    }

    postRequest(url = "", body = {}) {
        return fetch(url, {
            method: "POST"
        }).then(response => {
            if (response.status >= 200 && response.status < 300) {
                return response
            } else {
                let error = new Error(response.statusText);
                error.response = response;
                throw error;
            }
        })
            .then(response => response.json())
            .then(response => JSON.parse(response))
            .catch(error => console.warn("request failed", error));
    }
}