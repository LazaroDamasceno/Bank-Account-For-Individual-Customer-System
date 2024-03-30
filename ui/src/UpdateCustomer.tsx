import axios from "axios"
import { useState } from "react"

export const UpdateCustomer = () => {

    const [ssn, setSsn] = useState({
        ssn: '',
    })

    const [customer, setCustomer] = useState({
        name: '',
        birthDay: '',
        email: '',
        address: '',
        phoneNumber: ''
    })

    const handleChangeForSsn = (event: any) => {
        setSsn({...ssn, [event.target.name]:event.target.value})
    }

    const handleChangeForCustomer = (event: any) => {
        setCustomer({...customer, [event.target.name]:event.target.value})
    }

    async function updateCustomer() {
        await axios.put(`http://localhost:8080/api/v1/customer/${ssn.ssn}`, customer)
    }

    return (
        <>
            <head>
                <title>Update customer</title>
            </head>
            <body>
                <form onSubmit={updateCustomer}>
                    <div>
                        <div>
                            <label>Ssn: </label>
                            <input 
                                type="text"
                                value={ssn.ssn}
                                name="ssn"
                                onChange={handleChangeForSsn}
                            />
                        </div>
                        <br /><br />
                        <div>
                            <label>Name </label>
                            <input 
                                type="text"
                                value={customer.name}
                                name="name"
                                onChange={handleChangeForCustomer}
                            />
                        </div>
                        <br /><br />
                        <div>
                            <label>Birth Day: </label> 
                            <input 
                                type="date"
                                value={customer.birthDay}
                                name="birthDay"
                                onChange={handleChangeForCustomer}
                            />
                        </div>
                        <br /><br />
                        <div>
                            <label>Email: </label>
                            <input 
                                type="email"
                                value={customer.email}
                                name="email"
                                onChange={handleChangeForCustomer}
                            />
                        </div>
                        <br /><br />
                        <div>
                            <label>Address: </label>
                            <input 
                                    type="text"
                                    value={customer.address}
                                    name="address"
                                    onChange={handleChangeForCustomer}
                                />
                        </div>
                        <br /><br />
                        <div>
                            <label>Phone number: </label>
                            <input 
                                type="text"
                                value={customer.phoneNumber}
                                name="phoneNumber"
                                onChange={handleChangeForCustomer}
                            />    
                        </div>
                    </div>
                    <br /><br />
                    <input className="btn btn-warning" type="submit" value="Update"></input>
                </form>
            </body>
        </>
    )

}