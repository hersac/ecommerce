import axios from 'axios';

const obtenerToken = async ()=>{
    const credentials = {
        username: "admin",
        password: "admin"
    };

    const response = await axios.post('http://localhost/api/session', credentials);
    return response.data.token;
};

export const register = async (body: Object)=>{
    const token = await obtenerToken();
    const config = {
        headers: {
            Authorization: "Bearer " + token
        }
    };

    const res = await axios.post('http://localhost/api/usuarios', body, config);
    console.log(res.data);
};
