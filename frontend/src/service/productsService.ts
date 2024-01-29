import axios from 'axios';

const token = "eyJhbGciOiJzaGEyNTYiLCJ0eXAiOiJKV1QifQ==.eyJkYXRhIjpbeyJ1c2VyX2lkIjoxLCJ1c2VybmFtZSI6ImhlcnNhYzFAZ21haWwuY29tIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJwcmltZXJfbm9tYnJlIjoiSGVyaWJlcnRvIiwic2VndW5kb19ub21icmUiOiIgIiwicHJpbWVyX2FwZWxsaWRvIjoiU2FuY2hleiIsInNlZ3VuZG9fYXBlbGxpZG8iOiJDYXN0cm8iLCJkb2N1bWVudG9faWQiOiIxMDc1MjkyNDI4IiwiZGlyZWNjaW9uIjoiY2FycmVyYSAxIGEgYmlzIDY0IDA5In1dLCJleHAiOjE3MDU5NDc0OTl9.ynrbfqyvyFfn+xeD5C\/irTg+CiyI52UMaRToo9BUP\/Q=";

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
    });
}

export const updateProduct = (id: number, body: Object)=>{
    return axios.put(`http://localhost:80/api/productos/${id}`, body).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });
}

export const deleteProductById = (id: number)=>{
    return axios.delete(`http://localhost:80/api/productos/${id}`).then((response)=>{
        return response.data;
    }).catch(error=>{
        console.log(error);
    });
}
