import {http} from './config';


export default{

    listar:()=>{
        return http.get('oracions');
    },
    save:(oracion)=>{
        return http.post('oracions',oracion)
    },
    update:(oracion)=>{
        return http.put('oracions',oracion)
    },
    delete:(oracion)=>{
        return http.delete('oracions', { data: oracion })
    }


}