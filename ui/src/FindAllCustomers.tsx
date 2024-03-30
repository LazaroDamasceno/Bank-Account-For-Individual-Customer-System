import axios from "axios"
import { useEffect, useState } from "react"

export const FindAllCustomers = () => {

    const [customers, setCustomers] = useState([])

    useEffect(() => {
        async function findAll() {
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