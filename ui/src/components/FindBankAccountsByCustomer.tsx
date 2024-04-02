import axios from "axios"
import { useEffect, useState } from "react"
import { Link, useParams } from "react-router-dom"

export const FindBankAccountsByCustomers = () => {

    const { ssn } = useParams();

    const [bankaccounts, setBankAccounts] = useState([])

    useEffect(() => {
        const findAll = async () => {
            const response = await axios.get(`http://localhost:8080/api/v1/bank-accounts/${ssn}`)
            setBankAccounts(response.data)
        }
        findAll()
    }, [ssn])

    return (
        <>
            <head>
                <title>Find bank accounts by customer</title>
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
                <table>
                    <tr>
                        <th>Number:</th>
                        <th>Balance</th>
                        <th>Owner</th>
                        <th>Owner's SSN</th>
                    </tr>
                    {bankaccounts.map((bk: any) => (
                        <tr key={bk.id}>
                            <td>{bk.number}</td>
                            <td>{bk.balance}</td>
                            <td>{bk.customer.name}</td>
                            <td>{bk.customer.ssn}</td>
                        </tr>
                    ))}
                </table>
            </body>
        </>
    )

}