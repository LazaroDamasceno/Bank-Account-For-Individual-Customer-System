import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom"

export const FindAllCustomers = () => {

    const [customers, setCustomers] = useState([])

    useEffect(() => {
        const findAll = async () => {
            const response = await axios.get("http://localhost:8080/api/v1/customers")
            setCustomers(response.data)
        }
        findAll()
    }, [])

 
    return (
        <>
            <head>
                <title>Find all customers</title>
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
                <table>
                    <tr>
                        <th>Name</th>
                        <th>SSN</th>
                        <th>Birth Day</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Phone Number</th>
                    </tr>
                    {customers.map((customer: any) => (
                        <tr key={customer.id}>
                            <td>{customer.name}</td>
                            <td>{customer.ssn}</td>
                            <td>{customer.birthDay}</td>
                            <td>{customer.email}</td>
                            <td>{customer.address}</td>
                            <td>{customer.phoneNumber}</td>
                        </tr>
                    ))}
                </table>
            </body>
        </>
    )

}