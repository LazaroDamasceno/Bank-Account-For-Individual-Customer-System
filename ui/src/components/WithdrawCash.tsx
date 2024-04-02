import axios from "axios"
import { useState } from "react"
import { Link } from "react-router-dom"

export const WithdrawCash = () => {

    const [bankAccount, setbankAccount] = useState({
        ssn: '',
        number: '',
        cash: 0
    })

    const handleChange = (event: any) => {
        setbankAccount({...bankAccount, [event.target.name]:event.target.value})
    }

    async function withdraw() {
        axios.patch(`http://localhost:8080/api/v1/bank-account/ssn/${bankAccount.ssn}/number/${bankAccount.number}/cash/${bankAccount.cash}`)
    }

    return (
        <>
            <head>
                <title>Withdraw cash</title>
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
                </ul>
                <br/><br/>
                <hr/><hr/>
                <form onSubmit={withdraw}>
                    <div>
                        <label>SSN: </label>
                        <input 
                            name="ssn" 
                            type="text" 
                            value={bankAccount.ssn}
                            onChange={handleChange} 
                        />
                    </div>
                    <br/>
                    <div>
                        <label>Number: </label>
                        <input 
                            name="number" 
                            type="text" 
                            value={bankAccount.number}
                            onChange={handleChange} 
                        />
                    </div>
                    <br/>
                    <div>
                        <label>Cash: </label>
                        <input 
                            name="cash" 
                            type="number" 
                            value={bankAccount.cash}
                            onChange={handleChange} 
                        />
                    </div>
                    <br/>
                    <input type="submit" value="Withdrawn" />
                </form>
            </body>
        </> 
    )

}