import axios from "axios"
import { useState } from "react"

export const CreateBankAccount = () => {

    const [ssn, setSsn] = useState({
        ssn: ''
    })

    async function create() {
        await axios.post(`http://localhost:8080/api/v1/bank-account/${ssn.ssn}`)
    }

    const handleChange = (event: any) => {
        setSsn({...ssn, [event.target.name]:event.target.value})
    }

    return (
        <>
            <head>
            <title>Create banka account</title>
            </head>
            <body>
                <form onSubmit={create}>
                    <div>
                        <label>SSN: </label>
                        <input 
                            type="text" 
                            name="ssn" 
                            value={ssn.ssn} 
                            onChange={handleChange}
                        />
                    </div>
                    <br/><br/>
                    <input type="submit" className="btn btn-success" value="Create bank account" />
                </form>
            </body>
        </>
    )

}