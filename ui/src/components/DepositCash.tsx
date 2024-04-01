import axios from "axios"
import { useState } from "react"
import { Link } from "react-router-dom"

export const DepositCash = () => {

    const [bankAccount, setBankAccount] = useState({
        ssn: '',
        number: '',
        cash: 0
    })

    const handleChange = (event: any) => {
        setBankAccount({...bankAccount, [event.target.name]:event.target.value})
    }

    async function deposit() {
        axios.patch(`http://localhost:8080/api/v1/bank-account/${bankAccount.ssn}/${bankAccount.number}/${bankAccount.cash}`)
    }

    return (
        <>
            <head>
                <title>Deposit cash</title>
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
                </ul>
                <br/><br/>
                <hr/><hr/>
                <form onSubmit={deposit}>
                    <label>Customer's SSN: </label>
                    <input 
                        onChange={handleChange}
                        type="text"
                        name = "ssn"
                        value={bankAccount.ssn}
                    />
                    <br/><br/>
                    <label>Bank account's number: </label>
                    <input 
                        onChange={handleChange}
                        type="text"
                        name = "number"
                        value={bankAccount.number}
                    />
                    <br/><br/>
                    <label>Cash: </label>
                    <input 
                        onChange={handleChange}
                        type="number"
                        name = "cash"
                        value={bankAccount.cash}        
                    />
                    <br/><br/>
                    <input type="submit" value="Deposit" className="btn btn-success"/>
                </form>
            </body>
        </>
    )

}