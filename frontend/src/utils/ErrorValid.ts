import moment from 'moment';

let password = '';

export const validRequired = (value: any) => {
    if(!value){
        return "Este campo es obligatorio";
    }
};

export const validEmail = (value: any) => {
    validRequired(value);
    const regex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i;
    if (!regex.test(value)) {
      return 'Ingresa un email válido';
    }
};

export const validCedula = (value: any) => {
    validRequired(value);
    const regex = /^\d{9,10}$/;
    if (!regex.test(value)) {
        return 'Ingresa una cédula válida (de 9 a 10 dígitos)';
    }
};

export const validDirection = (value: any) => {
    validRequired(value);
    const regex = /^[a-zA-Z0-9]+$/;
    if (!regex.test(value)) {
        return 'Este campo no debe contener ningun tipo de simbolo (!"#$$%&/=|@·~½¬{[]}?¡)';
    }
};

export const validDate = (value: any) => {
    validRequired(value);
    const valorFecha = moment(value)
    const fechaActual = moment();
    if(!valorFecha.isBefore(fechaActual)){
        const fechaActualFormat = fechaActual.format('DD/MM/YYYY');
        return `La fecha tiene que ser menor a ${fechaActualFormat}`;
    }
};

export const validPassword = (value: any) => {
    validRequired(value);

    if (value?.length < 8) {
        return 'La contraseña debe tener al menos 8 caracteres';
    }
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]).{8,}$/;
    if (!regex.test(value)) {
        return 'La contraseña debe tener almenos 1 mayuscula, 1 minuscula, 1 numero y 1 simbolo';
    }
};

export const validConfirmPassword = (value: any) => {
    validRequired(value);

    if(value !== password){
        return 'Las contraseñas deben coincidir';
    }

};