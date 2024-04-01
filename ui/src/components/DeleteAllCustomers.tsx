import axios from "axios"
import { Link } from "react-router-dom"

export const DeleteAllCustomers = () => {

    async function deleteAll() {
        await axios.delete("http://localhost:8080/api/v1/customers")
    }

    return (
        <>
            <head>
                <title>Delete all customers</title>
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
                <form onSubmit={deleteAll}>
                    <input className="btn btn-warning" type="submit" value="Delete all customers" />
                </form>   
            </body>
        </>
    )

}