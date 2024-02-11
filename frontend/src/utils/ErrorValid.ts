import moment from 'moment';

let password = '';

export const validRequired = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    return true;
};

export const validEmail = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    const regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i;
    if (!regex.test(value)) {
      return 'Ingresa un email válido';
    }
    return true;
};

export const validCedula = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    const regex = /^\d{9,10}$/;
    if (!regex.test(value)) {
        return 'Ingresa una cédula válida (de 9 a 10 dígitos)';
    }
    return true;
};

export const validDireccion = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    const regex = /^[a-zA-Z0-9\s]+$/;
    if (!regex.test(value)) {
        return 'Este campo no debe contener ningun tipo de simbolo (!"#$$%&/=|@·~½¬{[]}?¡)';
    }
    return true;
};

export const validDate = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    const valorFecha = moment(value)
    const fechaActual = moment();
    if(!valorFecha.isBefore(fechaActual)){
        const fechaActualFormat = fechaActual.format('DD/MM/YYYY');
        return `La fecha tiene que ser menor a ${fechaActualFormat}`;
    }
    return true;
};

export const validPassword = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    if (value?.length < 8) {
        return 'La contraseña debe tener al menos 8 caracteres';
    }
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]).{8,}$/;
    if (!regex.test(value)) {
        return 'La contraseña debe tener almenos 1 mayuscula, 1 minuscula, 1 numero y 1 simbolo';
    }
    password = value;
    return true;
};

export const validConfirmPassword = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
    if(value !== password){
        return 'Las contraseñas deben coincidir';
    }
    return true;
};