import axios from 'axios';
import { obtenerToken } from './authServices/auth.service';
import { endpointUsuarios } from './authServices/getEnvironmentVariables.service';

const token: string | any = localStorage.getItem('TOKEN_CONSULTAS');
const header: Object = {
    Authorization: token
}

export const getUsuarios = async () => {
    return await axios.get(endpointUsuarios, header).then(response => {
        return response.data;
    });
};

export const getUsuarioPorId = async (id: number) => {
    return await axios.get(`${endpointUsuarios}/${id}`, header).then(response => {
        return response.data;
    });
};

export const getUsuarioPorEmail = async (email: string) => {
    return await axios.get(`${endpointUsuarios}/${email}`, header).then(response => {
        return response.data;
    });
};

export const createUsuario = async (body: Object) => {
    const headerAuth = await obtenerToken();
    return await axios.post(endpointUsuarios, body, headerAuth).then(response => {
        return response.data;
    });
};

export const updateUsuario = async (id: number, body: Object) => {
    return await axios.put(`${endpointUsuarios}/${id}`, body, header).then(response => {
        return response.data;
    });
};

export const deleteUsuarioPorId = async (id: number) => {
    return await axios.delete(`${endpointUsuarios}/${id}`, header).then(response => {
        return response.data;
    });
};