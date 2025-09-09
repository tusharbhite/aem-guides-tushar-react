import React, { Component } from 'react';
import { MapTo } from '@adobe/aem-spa-component-mapping';

export const CustomEditConfig = {
    emptyLabel:'Author',

    isEmpty: function(props){
        return !props || !props.firstName || props.firstName.trim().length<1;
    }
}

export default class Author extends Component{
    render(){
        if(CustomEditConfig.isEmpty(this.props)){
            return null;
        }

        return(
            <div className="AuthorComponent1">
                <h2 className="CustomComponent__message1">{this.props.firstName}</h2>
                <h2 className="CustomComponent__message1">{this.props.lastName}</h2>
                <h2 className="CustomComponent__message1">{this.props.isProfessor}</h2>
            </div>
        )
    }
}

MapTo('wknd-spa-react/components/author')(Author,CustomEditConfig);