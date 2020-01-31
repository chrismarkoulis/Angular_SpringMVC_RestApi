import { Component, OnInit } from '@angular/core';
import { Salesman } from './salesman';
import { SalesmanService } from './salesman.service';
import { Response } from '@angular/http';


@Component({

    selector: 'app-salesman',
    templateUrl: './salesman.component.html',
    styleUrls: ['./salesman.component.css'] //separate with comma different css files

})
export class SalesmanComponent implements OnInit {

    salesmanList: Salesman[];
    salesman = new Salesman();

    constructor(private _salesmanService: SalesmanService) { }

    ngOnInit(): void{

        this.getSalesmanList();
    }

    getSalesmanList(): void{

        this._salesmanService.getAllSalesmen()
        .subscribe((salesmanData) => {
            this.salesmanList = salesmanData,
            console.log(salesmanData)}, (error) =>{
            console.log(error);

        })

    }

    addSalesman(): void{

        this._salesmanService.addSalesman(this.salesman)
        .subscribe((response) => {console.log(response)
            this.resetFields();
            this.getSalesmanList();
        }
        , (error) => {

            console.log(error);

        })

    }

    private resetFields() {

        this.salesman.scode = null;
        this.salesman.sname = null;
        this.salesman.scity = null;
        this.salesman.scomm = null;

    }

    deleteSalesman(salesmanId: String){

        this._salesmanService.deleteSalesman(salesmanId)
        .subscribe((response) => {console.log(response);
        this.getSalesmanList();
        
        
        }, (error) => {console.log(error);
        })
    }

    getSalesmanById(salesmanId: String){
        this._salesmanService.getSalesmanById(salesmanId)
        .subscribe((salesmanData) => {this.salesman = salesmanData; this.getSalesmanList();
        }, (error) => {
            console.log(error);
        })
    }


}
