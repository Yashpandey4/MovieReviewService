const validations = {
    firstLastName: {
        pattern: {
            value: /^[A-Za-z]{1,}$/,
            message: 'Enter Valid name'
        },
        required: {
            value: true,
            message: 'Its required'
        }
    },
    middleName: {
        pattern: {
            value: /^[A-Za-z]{1,}$/,
            message: 'Enter Valid name'
        }
    },
    phoneNumber: {
        pattern: {
            value: /^[0-9]{10}$/,
            message: 'enter valid phone number'
        },
        required: {
            value: true,
            message: 'Its required'
        }
    },
    email: {
        pattern: {
            value: /^([a-zA-Z0-9_\-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
            message: 'enter valid email'
        },
        required: {
            value: true,
            message: 'Its required'
        }
    },
    general: {
        required: { value: true, message: 'Its required' }
    },
    NumberOfmonths: {
        min: 0,
        max: { value: 11, message: 'Months should be less than 12' },
        required: { value: true, message: 'Its required' }
    }
}

export const Personal = [
    {
        placeholder: 'First Name',
        name: 'firstName',
        validation: validations['firstLastName'],
        component: 'text'

    },
    {
        placeholder: 'Middle Name(Optional)',
        name: 'middleName',
        validation: validations['middleName'],
        component: 'text'
    },
    {
        placeholder: 'Last Name',
        name: 'lastName',
        validation: validations['firstLastName'],
        component: 'text'
    },
    {
        placeholder: 'Phone Number',
        name: 'phoneNumber',
        component: 'phoneNumber',
        validation: validations['phoneNumber']
    },
    {
        placeholder: 'E-mail',
        name: 'email',
        component: 'text',
        validation: validations['email']
    },
    {
        placeholder: 'Mailing Adress',
        dependent: [
            'phoneNumber',
            'email'
        ],
        name: 'adress',
        component: 'text',
        validation: validations['general']
    },
    {
        placeholder: 'Is the residence adress same as mailing adress?',
        name: 'sameAdress',
        component: 'select',
        values: [
            'yes',
            'no'
        ],
        validation: validations['general']

    },
    {
        placeholder: 'How long has the insured lived at their current adress?',
        name: 'display1',
        component: 'display_text'
    },
    {
        placeholder: 'Years',
        name: 'yearsLived',
        component: 'number',
        validation: { required: { value: true, message: 'Its required' }, min: 0 }

    },
    {
        placeholder: 'Months',
        name: 'monthsLived',
        component: 'number',
        validation: validations['NumberOfmonths'],
    }
]

export const Business = [
    {
        placeholder: 'First Name',
        name: 'firstName',
        validation: validations['firstLastName'],
        component: 'text'

    },
    {
        placeholder: 'Middle Name(Optional)',
        name: 'middleName',
        validation: validations['middleName'],
        component: 'text'
    },
    {
        placeholder: 'Last Name',
        name: 'lastName',
        validation: validations['firstLastName'],
        component: 'text'
    },
    {
        placeholder: 'Phone Number',
        name: 'phoneNumber',
        component: 'phoneNumber',
        validation: validations['phoneNumber']
    },
    {
        placeholder: 'E-mail',
        name: 'email',
        component: 'text',
        validation: validations['email']
    },
    {
        placeholder: 'Reletionship to Business',
        name: 'relationBusiness',
        component: 'text',
        validation: validations['general']

    },
    {
        placeholder: 'Business Name',
        name: 'businessName',
        component: 'text',
        validation: validations['general']

    },
    {
        placeholder: 'Business Adress',
        name: 'businessAdress',
        component: 'text',
        validation: validations['general']

    },
    {
        placeholder: 'Industry',
        name: 'industry',
        component: 'text',
        validation: validations['general']
    }

]