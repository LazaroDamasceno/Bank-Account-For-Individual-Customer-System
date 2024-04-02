import axios from "axios"
import { useState } from "react"
import { Link } from "react-router-dom"

export const CreateBankAccount = () => {

    const [ssn, setSsn] = useState({
        ssn: ''
    })

    const create = async () => {
        await axios.post(`http://localhost:8080/api/v1/bank-account/${ssn.ssn}`)
    }

    const handleChange = (event: any) => {
        setSsn({...ssn, [event.target.name]:event.target.value})
    }

    return (
        <>
            <head>
                    <title>Create banka account</title>
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
                        <Link to="find-bank-account-by-customer">Withdraw cash</Link>
                    </li>
                </ul>
                <br/><br/>
                <hr/><hr/>
                <form onSubmit={create}>
                    <div>
                        <label>SSN: </label>
                        <input 
                            type="text" 
                            name="ssn" 
                            value={ssn.ssn} 
                            onChange={handleChange}
                        />
                    </div>
                    <br/><br/>
                    <input type="submit" className="btn btn-success" value="Create bank account" />
                </form>
            </body>
        </>
    )

}