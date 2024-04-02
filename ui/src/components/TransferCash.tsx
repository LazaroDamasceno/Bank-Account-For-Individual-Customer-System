import axios from "axios"
import { useState } from "react"
import { Link } from "react-router-dom"

export const TransferCash = () => {

    const [bankAccount, setBankAccount] = useState({
        ssn: '',
        number1: '',
        cash: 0,
        number2: ''
    })

    const handleChange = (event: any) => {
        setBankAccount({...bankAccount, [event.target.name]:event.target.value})
    }

    const transfer = async () =>  {
        await axios.patch(`http://localhost:8080/api/v1/bank-account/${bankAccount.ssn}/${bankAccount.number1}/${bankAccount.cash}/${bankAccount.number2}`)
    }

    return (
        <>
            <head>
                <title>Transfer cash</title>
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
                <form onSubmit={transfer}>
                    <div>
                        <label>SSn of the person who's going to transfer cash:</label>
                        <input 
                            name="ssn"
                            type="text"
                            value={bankAccount.ssn}
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Number's bank account who's going to transfer cash:</label>
                        <input 
                            name="number1"
                            type="text"
                            value={bankAccount.number1}
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Cash to be transfer:</label>
                        <input 
                            name="cash"
                            type="number"
                            value={bankAccount.cash}
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <div>
                        <label>Number's bank account who's going to receive the cash:</label>
                        <input 
                            name="number2"
                            type="text"
                            value={bankAccount.number2}
                            onChange={handleChange}
                        />
                    </div>
                    <br /><br />
                    <input className="btn btn-success" type="submit" value="Transfer" />
                </form>
            </body>
        </>
    )

}