$version: "2"
namespace imputation


use alloy#simpleRestJson

@simpleRestJson
service UserService {
    operations: [
    GetUsers,
    GetUser,
    CreateUser,
    DeleteUser,
    EditUser
    ]

}

@http(method: "GET", uri: "/users")
operation GetUsers {
    output:= {
        users: Users
    } 

}

@http(method: "GET", uri: "/users/{id}")
operation GetUser{
    input := {
        @required
        @httpLabel
        id: UUID
    }
    output : User
}

@http(method: "POST", uri: "/users")
operation CreateUser {
    input := {
        @required
        name: String,
        @required
        status: Status,
        @required
        job: Job,
        @required
        role: Roles
    }

    output := {
        id: UUID
    }
    
}

@http(method: "DELETE", uri: "/users/{id}")
operation DeleteUser {
    input := {
        @required
        @httpLabel
        id: UUID
    }
    output := {
        id: UUID
    }

}

@http(method: "PATCH", uri: "/users/{id}")
operation EditUser {
    input := {
        @required
        @httpLabel
        id: UUID,
        name: String,
        status: Status,
        job: Job,
        role: Roles
    }

    output := {
        id: UUID
    }
    
}


list Users {
        member: User
    }

structure User {
    @required
    id: UUID,
    @required
    name: String,
    @required
    status: Status,
    @required
    job: Job,
    @required
    role: Roles
}


list Roles {
    member: Role
}

string Role
string Job
string Status
string UUID

