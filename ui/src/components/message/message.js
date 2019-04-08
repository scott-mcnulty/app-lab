import React from 'react';

class MessageComponent extends React.Component {

    constructor(props) {
        super(props);
        this.stage = {
            id: props.id,
            message: props.message
        }
    }
}

export default MessageComponent;