import axios from "axios"
import { useEffect, useState } from "react"

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