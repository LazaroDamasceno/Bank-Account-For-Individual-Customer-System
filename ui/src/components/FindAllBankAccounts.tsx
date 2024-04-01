import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom"


export const FindAllBankAccounts = () => {

    const [bankAccounts, setBankAccounts] = useState([])

    useEffect(() => {
        async function findAll() {
            const response = await axios.get("http://localhost:8080/api/v1/bank-accounts")
            setBankAccounts(response.data)
        }
        findAll()
    }, [])

    return (
        <>
            <head>
                <title>Find all bank accounts</title>
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
                <table>
                    <tr>
                        <th>Number</th>
                        <th>Balance</th>
                        <th>Owner</th>
                        <th>Owner's SSN</th>
                    </tr>
                    {bankAccounts.map((bankAccount: any) => (
                        <tr key={bankAccount.id}>
                            <td>{bankAccount.number}</td>
                            <td>{bankAccount.balance}</td>
                            <td>{bankAccount.customer.name}</td>
                            <td>{bankAccount.customer.ssn}</td>
                        </tr>
                    ))}
                </table>
            </body>
        </>
    )

}