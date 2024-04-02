import axios from "axios"
import { useState } from "react"
import { Link } from "react-router-dom"

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

    const updateCustomer = async () => {
        await axios.put(`http://localhost:8080/api/v1/customer/${ssn.ssn}`, customer)
    }

    return (
        <>
            <head>
                <title>Update customer</title>
            </head>
            <body>
            <br/><br/>
                <ul>
                    <li>
                        <Link to="/register-customer">Register customer</Link>
                    </li>
                    <br/>
                    <li>
                        <Link to="/update-customer">Updated customer</Link>
                    </li>
                    <br />
                    <li>
                        <Link to="/create-bank-account">Create bank account</Link>
                    </li>
                    <br/>
                    <li>
                        <Link to="/delete-all-customers">Delete all customers</Link>
                    </li>
                    <br />
                    <li>
                        <Link to="/find-all-customers"> Find all customers</Link>
                    </li>
                    <br />
                    <li>
                        <Link to="/find-all-bank-accounts"> Find all bank accounts</Link>
                    </li>
                    <br/>
                    <li>
                        <Link to="/deposit-cash">Deposit cash</Link>
                    </li>
                    <br/>
                    <li>
                        <Link to="/transfer-cash">Transfer cash</Link>
                    </li>
                    <br />
                    <li>
                        <Link to="/withdraw-cash">Withdraw cash</Link>
                    </li>
                    <br />
                    <li>
                        <Link to="/find-bank-account-by-customer">Find bank accounts by customer</Link>
                    </li>
                </ul>
                <br/><br/>
                <hr/><hr/>
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