import moment from 'moment';

export const formatearFecha = (fecha: string) => {
    const fechaFormateada = moment(fecha).format('DD/MM/YYYY');
    return fechaFormateada;
};
