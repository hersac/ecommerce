import axios from 'axios';
import store from '../../store/index';

const obtenerToken = async ()=>{
    const credentials = {
        username: "admin",
        password: "admin"
    };
    const response = await axios.post('http://localhost/api/session', credentials);
    const config = {
        headers: {
            Authorization: "Bearer " + response.data.token,
        }
    };
    return config;
};

export const register = async (body: Object) => {
    const header = await obtenerToken();
    return await axios.post('http://localhost/api/usuarios', body, header);
};

export const login = async (body: Object) => {
    const header = await obtenerToken();
    const response = await axios.post('http://localhost/api/session', body, header);
    if(response.data.status === 401){
        return false;
    }
    localStorage.setItem('TOKEN_CONSULTAS', response.data.token);
    return true
};
