import axios from "axios"
import { useState } from "react"

export const RegisterCustomer= () => {

    const [customer, setCustomer] = useState({
        name: '',
        ssn: '',
        birthDay: '',
        email: '',
        address: '',
        phoneNumber: ''
    })

    const handleChange = (event: any) => {
        setCustomer({...customer, [event.target.name]:event.target.value})
    }

    async function registerCustomer() {
        await axios.post("http://localhost:8080/api/v1/customer", customer)
    }

    return (
        <>
            <head>
                <title>Register customer</title>
            </head>
            <body>
                <form onSubmit={registerCustomer}>
                    <div>
                        <label>Name: </label>
                        <input 
                            type="text"
                            value={customer.name}
                            name="name"
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Ssn: </label>
                         <input 
                            type="text"
                            value={customer.ssn}
                            name="ssn"
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Birth Day: </label> 
                        <input 
                            type="date"
                            value={customer.birthDay}
                            name="birthDay"
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Email: </label>
                        <input 
                            type="email"
                            value={customer.email}
                            name="email"
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Address: </label>
                        <input 
                                type="text"
                                value={customer.address}
                                name="address"
                                onChange={handleChange}
                            />
                    </div>
                    <br /><br />
                    <div>
                        <label>Phone number: </label>
                        <input 
                            type="text"
                            value={customer.phoneNumber}
                            name="phoneNumber"
                            onChange={handleChange}
                        />    
                    </div>
                    <br /><br />
                    <input className="btn btn-success" type="submit" value="Register"></input>
                </form>
            </body>
        </>
    )
}