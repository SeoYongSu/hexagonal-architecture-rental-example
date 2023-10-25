package com.example.rent.application.port.in;

import com.example.rent.application.service.UseCase;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.RentalStatus;
import lombok.Getter;

public interface GetProductUseCase extends UseCase<GetProductUseCase.Input, GetProductUseCase.Output>{

    record Input(
            String productId
    ) implements UseCase.InputValues{
        public Input {
            if (productId == null || productId.isEmpty())
                throw new IllegalArgumentException("제품 ID는 필수입니다");
        }
    }

    @Getter
    class Output implements Product, UseCase.OutputValues{
        private String id;
        private String name;
        private String productType;
        private RentalStatus status;

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getProductType() {
            return this.productType;
        }

        public Output(Product product, RentalStatus status){
            this.id = product.getId();
            this.name = product.getName();
            this.productType = product.getProductType();
            this.status = status;
        }
    }
}
