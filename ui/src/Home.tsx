import { Link } from "react-router-dom"

export const Home = () => {

    return (
        <>
            <h1>Welcome to my app</h1>
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
            </ul>
        </>
    )

}