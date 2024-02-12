import axios from 'axios';

const token: string | any = localStorage.getItem('TOKEN_CONSULTAS');

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
