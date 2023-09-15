import { Axios } from "axios"



export const changePasswordPost = async(filterData)=>
{
    return Axios
    .post('api/users/changePassword', filterData)
    .then((response)=>response.data);
}