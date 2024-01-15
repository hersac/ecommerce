import axios, { AxiosResponse } from 'axios';

const token = "eyJhbGciOiJzaGEyNTYiLCJ0eXAiOiJKV1QifQ==.eyJkYXRhIjpbeyJ1c2VyX2lkIjoxLCJ1c2VybmFtZSI6ImhlcnNhYzFAZ21haWwuY29tIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJwcmltZXJfbm9tYnJlIjoiSGVyaWJlcnRvIiwic2VndW5kb19ub21icmUiOiIgIiwicHJpbWVyX2FwZWxsaWRvIjoiU2FuY2hleiIsInNlZ3VuZG9fYXBlbGxpZG8iOiJDYXN0cm8iLCJkb2N1bWVudG9faWQiOiIxMDc1MjkyNDI4IiwiZGlyZWNjaW9uIjoiY2FycmVyYSAxIGEgYmlzIDY0IDA5In1dLCJleHAiOjE3MDUzNjU2ODd9.vZQGiJ7KZ0M92xA4Imr7iH5rkSRWMyWfq42CimcmWU4=";

const headers ={
    'Authorization': `Bearer ${token}`
}

export const getProducts = (): Promise<AxiosResponse<any>> =>{
    return axios.get('http://localhost:80/api/productos', { headers });
}

export const getProductById = (id: number)=>{
    return axios.get(`http://localhost:80/api/productos/${id}`);
}
