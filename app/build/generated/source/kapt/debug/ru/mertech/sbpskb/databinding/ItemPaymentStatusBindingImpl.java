package ru.mertech.sbpskb.databinding;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPaymentStatusBindingImpl extends ItemPaymentStatusBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.reload, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemPaymentStatusBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemPaymentStatusBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[5]
            );
        this.amount.setTag(null);
        this.date.setTag(null);
        this.imageView.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.paymentId.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.payment == variableId) {
            setPayment((ru.mertech.sbpskb.db.entity.PaymentStatusEntity) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((ru.mertech.sbpskb.ui.viewModels.ShareViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPayment(@Nullable ru.mertech.sbpskb.db.entity.PaymentStatusEntity Payment) {
        this.mPayment = Payment;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.payment);
        super.requestRebind();
    }
    public void setViewModel(@Nullable ru.mertech.sbpskb.ui.viewModels.ShareViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean paymentPaymentIDEmpty = false;
        java.lang.String paymentPaymentIDEmptyPaymentPaymentIDJavaLangStringUnknown = null;
        java.lang.String paymentPaymentID = null;
        java.lang.String paymentAmount = null;
        boolean PaymentPaymentIDEmpty1 = false;
        ru.mertech.sbpskb.db.entity.PaymentStatusEntity payment = mPayment;

        if ((dirtyFlags & 0x5L) != 0) {



                if (payment != null) {
                    // read payment.paymentID
                    paymentPaymentID = payment.getPaymentID();
                    // read payment.amount
                    paymentAmount = payment.getAmount();
                }


                if (paymentPaymentID != null) {
                    // read payment.paymentID.empty
                    PaymentPaymentIDEmpty1 = paymentPaymentID.isEmpty();
                }


                // read !payment.paymentID.empty
                paymentPaymentIDEmpty = !PaymentPaymentIDEmpty1;
            if((dirtyFlags & 0x5L) != 0) {
                if(paymentPaymentIDEmpty) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x5L) != 0) {

                // read !payment.paymentID.empty ? payment.paymentID : "Unknown"
                paymentPaymentIDEmptyPaymentPaymentIDJavaLangStringUnknown = ((paymentPaymentIDEmpty) ? (paymentPaymentID) : ("Unknown"));
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.amount, paymentAmount);
            ru.mertech.sbpskb.ui.adapters.BindingAdapterKt.getDate(this.date, payment);
            ru.mertech.sbpskb.ui.adapters.BindingAdapterKt.getImg(this.imageView, payment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.paymentId, paymentPaymentIDEmptyPaymentPaymentIDJavaLangStringUnknown);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): payment
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): !payment.paymentID.empty ? payment.paymentID : "Unknown"
        flag 4 (0x5L): !payment.paymentID.empty ? payment.paymentID : "Unknown"
    flag mapping end*/
    //end
}