import axios from 'axios';

const token = "eyJhbGciOiJzaGEyNTYiLCJ0eXAiOiJKV1QifQ==.eyJkYXRhIjpbeyJ1c2VyX2lkIjoxLCJ1c2VybmFtZSI6ImhlcnNhYzFAZ21haWwuY29tIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJwcmltZXJfbm9tYnJlIjoicHJ1ZWJhIDEiLCJzZWd1bmRvX25vbWJyZSI6InBydWViYSAxIiwicHJpbWVyX2FwZWxsaWRvIjoicHJ1ZWJhIDEiLCJzZWd1bmRvX2FwZWxsaWRvIjoicHJ1ZWJhIDEiLCJkb2N1bWVudG9faWQiOiIxMDc1MjkyNDI4IiwiZGlyZWNjaW9uIjoiY2FycmVyYSAxIGEgYmlzIDY0IDA5In1dLCJleHAiOjE3MDU0MzUxNDl9.ASfPjlZAYHBrcTar9JHdrH+aNRDbnsJnTZJusbuv+JQ=";

const headers ={
    'Authorization': `Bearer ${token}`
}

export const getProducts = () =>{
    return axios.get('http://localhost:80/api/productos', { headers }).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });
}

export const getProductById = (id: number)=>{
    return axios.get(`http://localhost:80/api/productos/${id}`).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });;
}

export const createProduct = (body: Object)=>{
    return axios.post(`http://localhost:80/api/productos`, body).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });;
}

export const updateProduct = (id: number, body: Object)=>{
    return axios.put(`http://localhost:80/api/productos/${id}`, body).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });;
}

export const deleteProductById = (id: number)=>{
    return axios.delete(`http://localhost:80/api/productos/${id}`).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });;
}
