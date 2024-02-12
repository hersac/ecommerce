import axios from 'axios';
import { userRoot, passwordRoot, endpointSesion, endpointUsuarios } from './getEnvironmentVariables.service';

export const obtenerToken = async ()=>{
    const credentials = {
        username: userRoot,
        password: passwordRoot
    };
    const response = await axios.post(endpointSesion, credentials);
    const config = {
        headers: {
            Authorization: "Bearer " + response.data.token,
        }
    };
    return config;
};

export const login = async (body: Object) => {
    const header = await obtenerToken();
    const response = await axios.post(endpointSesion, body, header);
    if(response.data.status === 401){
        return false;
    }
    localStorage.setItem('TOKEN_CONSULTAS', response.data.token);
    return true
};
